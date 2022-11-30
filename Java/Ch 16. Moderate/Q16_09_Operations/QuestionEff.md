16.9 - Operations
---
> Write methods to implement the multiply, subtract, and divide operations for integers.
> The results of all of these are integers. Use only the add operator.

In [the first solution](https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2016.%20Moderate/Q16_09_Operations/Question.java), we managed to implement requested methods: `subtract`, `multiply` and `divide`. Let's assess their time complexity:
- `subtract(a, b)` takes O((log b)<sup>2</sup>) (see the book for thorough explanation)
- `multiply(a, b)` takes O(b) because we add `a` to itself `b` times
- `divide(a, b)` takes O(a / b) because we add up `b` (until it becomes equal to `a`) `a / b` times

Now, we'll try to improve the asymptotics of our functions. In order to do this, we'll apply some bit level manipulations keeping in mind that only `+` operator is allowed. Let's start from the `negate` function.

---

### negate (unary `-`)

On bit level, negation is performed as inversion of each bit and addition of 1. For example, 12<sub>10</sub> = 00001100<sub>2</sub>. After inversing every bit, we get 11110011. Add 1 to this: 11110100<sub>2</sub> = -12<sub>10</sub>. To verify that the result is correct, we need to add 12: 11110100 + 00001100 = 00000000 - zero, as expected. So, our implementation becomes:
```java
int subtract(int a, int b) { return a + negate(b); } // same as before
int negate(int n) { return bitNot(n) + 1; } // different
```
where `bitNot` is a bit inversion operator (`~`) that needs to be implemented.

---

### bitNot (`~`)

If we had a function that allowed us to morph one number to another one bit by bit then we could implement `bitNot` like this, using functional approach:
```java
int bitNot(int n) { return traverseBits(n, bit -> bit == 0 ? 1 : 0); }
```
So, we simply map every bit to the opposite value.

If you aren't familiar with lambda notation then here's the equivalent code using a class:
```java
interface BitMapper {
    int map(int bit);
}
final BitMapper BIT_NOT = new BitMapper() {
    @Override
    int map(int bit) {
        return bit == 0 ? 1 : 0;
    }
}
int bitNot(int n) {
    return traverseBits(n, BIT_NOT);
}
int traverseBits(int n, BitMapper mapper) {
    <...>
    int newBit = mapper.map(oldBit);
    <...>
}
```
Thus, now we have to find a way to implement `traverseBits`. Sometimes, it's useful to solve a high level task first, and then to find missing pieces of the puzzle.

---

### dec (`--`) and inc (`++`)

Apparently, we will require loops in this task. And to make simple loops, we need decrement and increment operators. Let's be purists here: if we're only allowed to use `+` then `++` is also prohibited! :stuck_out_tongue_winking_eye:

While increment is trivial, decrement requires a constant `-1`. But how can we define it if unary minus (`-`) is prohibited? We can use hexadecimal notation: -1<sub>10</sub> = 1111...1111<sub>2</sub> (a number with all bits set to 1) = FFFFFFFF<sub>16</sub>. Easy to remember: adding 1 to it will turn it into 0, so that's what we need.
```java
final int NEGATIVE_ONE = 0xFFFFFFFF;
int dec(int n){ return n + NEGATIVE_ONE; }
int inc(int n){ return n + 1; }
```

---

### traverseBits

The pseudocode of `traverseBits` function:
```java
int traverseBits(int n, BitMapper mapper) {
    int result = 0;
    for (int i = 31; i >= 0; i--) {
        int oldBit = extract the last bit of n
        int newBit = mapper.map(oldBit);
        result[i] = newBit; // set newBit in position "i"
        n <<= 1;
    }
    return result;
}
```
It's only left to fill the gaps:
- the last bit is the sign bit. If a number is less than 0 then this bit is set (and vice versa). That's how we get it: `oldBit = n < 0 ? 1 : 0`.
- setting a bit at some position is just the addition of 2<sup>i</sup> because "result" is zero initially, and indicies never overlap
- to quickly get 2<sup>i</sup>, we can pre-compute 32 integers each having 1 bit set in all possible slots (using left shift - `<<`)
- shifting a number to the left by one bit is literally multiplying by 2, i.e. adding the number to itself

The time complexity of our method is O(W) where W is the machine word size (32 for int). Since we traverse all the bits of a number, it's rather closer to O(log n) than to O(1). But it's definitely better than O((log n)<sup>2</sup>) we had before. The new implementation will outperform on large numbers (such as billion).

---

### left shift (`<<`)

Of course, a general implementation of left shift accepts an argument "number of bits to shift by" (and therefore requires a loop), but for our needs, it's enough to shift by 1 bit:
```java
int leftShift(int n) { return n + n; }
```

---

### multiply (`*`)

We will use a classic multiplication algorithm taught to everyone in school. But we'll do it for binary representation. See example:
```text
    1101 = a = 13
   * 110 = b = 6
----------|- a -
     110  |  1
          |  0
 + 110    |  1
+ 110     |  1
----------|-----
 1001110 = 78
```
Pseudocode:
```java
int multiply(int a, int b) {
    int result = 0;
    for (repeat 32 times) {
        result <<= 1;
        if (last bit of a == 1) {
            result += b;
        }
        a <<= 1;
    }
    return result;
}
```
Note that there are no exceptional situations: this algorithm works correctly for negative numbers and in case of overflow, no adjustments are needed.

Complexity is O(W), and it's a significant improvement comparing to prior O(n) = O(2<sup>W</sup>) approach.

---

### divide (`/`)

The division algorithm also comes from school lessons. Take a look at the example:
```text
Step 1: find multiplier (align divisor with dividend but don't overflow)

   10011 | 110
---------|----
     110 | 1 is not enough => shift
    1100 | 10 is still small => try to shift again
   11000 | 100 is too much => keep 10

Step 2: subtract

   10011 | 110
---------|----
  - 1100 | 10
     111 |

Step 3: repeat on remainder

     111 | 110
---------|----
     110 | 1 doesn't overflow => shift
    1100 | 10 is too much => keep 1

Step 4: subtract

    111 - 110 = 1 => remainder is less than divisor => finish the loop

Step 5: sum up the result

     10 + 1 = 11 => done
```

Pseudocode:
```java
int divide(int a, int b) {
    int result = 0;
    while (a >= b) {
        int shift = -1;
        int shifted = b;
        int previous = b;
        while (shifted <= a) {
            previous = shifted;
            shifted <<= 1;
            shift++;
        }
        a -= previous;
        result[shift] = 1; // set bit at position "shift"
    }
    return result;
}
```

On each iteration of the outer loop, at least one bit of `a` is erased. The inner loop takes O(W). Subtraction is also O(W). Total time is O(W<sup>2</sup>). It's slower than for `subtract` and `multiply` but faster than O(a / b) = O(2<sup>W</sup>) of our previous solution.

Please be careful with division - it's very tricky:
- first of all, the value of `shifted` may overflow. To avoid this, we can ensure that the last bit is free. It means that we need to get rid of negative numbers and work only with positive ones.
- secondly, if `a` is large, and `shifted` is doubled to occupy the last bit then `shifted` becomes negative. So, the condition `shifted <= a` should actually be `shifted >= 0 && shifted <= a`.
- getting rid of negative numbers seems to be easy, right? `if (a < 0) return negate(divide(negate(a), b))` - and the same for `b`. Yes, almost. However, there's one important special case - it's `Integer.MIN_VALUE` = -2<sup>31</sup>. This is a negative number which doesn't have its positive counterpart. If you try to negate it, you'll get the same number. Therefore, it has to be carefully handled. If divisor is `MIN_VALUE` then the result is 0 because `MIN_VALUE` is a big number (despite that it's negative) - its absolute value is greater than any other int32. Except itself. If both `a` and `b` are `MIN_VALUE` then the result is 1. Things get interesting when `a` is `MIN_VALUE` (and `b` is positive at this point). Result has to be really calculated, we can't just hardcode it as in case of `b = MIN_VALUE`. The following formula helps: `a / b = (a + b) / b - 1`. Since `b` is positive, adding it to negative `a` will decrease the absolute value of `a`, and we'll be able to negate it in a regular manner.
- finally, the most obvious exception related to division is division by zero. Standard Java division throws an error, so it could be reasonable to do the same. Other languages may behave differently. Anyway, it's always worth discussing such exceptional cases with your interviewer.

---

The full code listing for this solution also contains an implementation of all other standard operators (such as `%`, `>>>` and `^`) just for reference. It's highly unlikely though that you'll be asked to add all of them during an interview.
