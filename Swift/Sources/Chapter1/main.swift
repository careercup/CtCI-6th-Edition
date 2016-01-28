// Cracking the Coding Interview 6th Edition Solutions

// MARK: Chapter 1 - Arrays and Strings

precondition("The quick brown fox jumps over the lazy dog".isUnique() == false, "1.1 failed")
precondition("TheQuickFox".isUnique() == true, "1.1 failed")
precondition("".isUnique() == true, "1.1 failed")
precondition("a".isUnique() == true, "1.1 failed")

precondition("The quick brown fox jumps over the lazy dog".isUniqueNoDS() == false, "1.1 failed")
precondition("TheQuickFox".isUniqueNoDS() == true, "1.1 failed")
precondition("".isUniqueNoDS() == true, "1.1 failed")
precondition("a".isUniqueNoDS() == true, "1.1 failed")

print("Well done! 1.1 passed all tests!")

precondition("cat".isPermutation(Of: "tac") == true, "1.2 failed")
precondition("cat".isPermutation(Of: "dog") == false, "1.2 failed")
precondition("cat".isPermutation(Of: "catcat") == false, "1.2 failed")

print("Well done! 1.2 passed all tests!")

precondition("Mr. John Smith".URLify() == "Mr.%20John%20Smith", "1.3 failed")
precondition("Mr. Bean".URLify() == "Mr.%20Bean", "1.3 failed")
precondition("NoSpaces".URLify() == "NoSpaces", "1.3 failed")

print("Well done! 1.3 passed all tests!")

precondition("Tact Coa".isPalindromePermutation() == true, "1.4 failed")

print("Well done! 1.4 passed all tests!")

precondition("pale".isOneAway(From: "ple") == true, "1.5 failed")
precondition("pales".isOneAway(From: "pale") == true, "1.5 failed")
precondition("pale".isOneAway(From: "bale") == true, "1.5 failed")
precondition("pale".isOneAway(From: "bake") == false, "1.5 failed")

print("Well done! 1.5 passed all tests!")

precondition("aabcccccaaa".compress() == "a2b1c5a3", "1.6 failed")
precondition("a".compress() == "a", "1.6 failed")

print("Well done! 1.6 passed all tests!")

var m1 = Matrix(matrix: [
    [ 1, 2, 3, 4 ],
    [ 0, 4, 1, 3 ],
    [ 5, 9, 8, 7 ],
    [ 6, 2, 0, 1 ]
])

let m2 =
[
    [ 6, 5, 0, 1 ],
    [ 2, 9, 4, 2 ],
    [ 0, 8, 1, 3 ],
    [ 1, 7, 3, 4 ]
]

precondition(m1.rotate().matrix == m2, "1.7 failed")

print("Well done! 1.7 passed all tests!")

m1 = Matrix(matrix: [
    [ 1, 2, 3, 4 ],
    [ 0, 4, 1, 3 ],
    [ 5, 9, 8, 7 ],
    [ 6, 2, 0, 1 ]
])

let m3 =
[
    [ 0, 2, 0, 4 ],
    [ 0, 0, 0, 0 ],
    [ 0, 9, 0, 7 ],
    [ 0, 0, 0, 0 ]
]


precondition(m1.zero().matrix == m3, "1.8 failed")

print("Well done! 1.8 passed all tests!")

precondition("waterbottle".isRotation(Of: "erbottlewat") == true, "1.9 failed")

print("Well done! 1.9 passed all tests!")

print("You did it! Chapter 1 is complete!")