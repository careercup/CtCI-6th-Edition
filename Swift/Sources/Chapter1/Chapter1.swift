// Cracking the Coding Interview 6th Edition Solutions

import Foundation

// MARK: Question 1.1
extension String {

    /// Time Complexity:  O(n)
    /// Space Complexity: O(n)
    func isUnique() -> Bool {

        let uniqueChars = Set<Character>(self.characters)
        return uniqueChars.count == self.characters.count
    }

    /// Time Complexity:  O(n^2)
    /// Space Complexity: O(1)
    ///
    /// A faster solution could be achieved by sorting the elements in place
    /// with Quicksort in O(n * log(n))
    func isUniqueNoDS() -> Bool {
        
        for (idx, c) in self.characters.enumerate() {

            for i in idx.successor()..<self.characters.count {
                
                if c == self[self.startIndex.advancedBy(i)] {
                    
                    return false
                }
            }
        }
        return true
    }
}

// MARK: Question 1.2
extension String {

    /// Time Complexity:  O(n * log(n))
    /// Space Complexity: O(n)
    func isPermutation(Of other: String) -> Bool {
        
        guard self.characters.count == other.characters.count else {
            
            /// `self` can't be a permutation if `other`
            /// has a different size
            return false
        }
        
        return self.characters.sort() == other.characters.sort()
    }
}

// MARK: Question 1.3
extension String {

    /// Time Complexity:  O(n) whereas n == the buffer's final length
    /// Space Complexity: O(n) due to copy operations
    func URLify() -> String {
    
        let whitespaces = self.characters.filter { $0 == " " }.count
        
        guard whitespaces > 0 else {
            
            /// Nothing to do here
            return self
        }
        
        var chars = Array(self.characters) + Array(count: whitespaces * 2, repeatedValue: " ")

        var charPosition = chars.startIndex.advancedBy(self.characters.count - 1)
        var bufferPosition = chars.endIndex.predecessor()
        
        while charPosition >= chars.startIndex && bufferPosition >= charPosition {
        
            if chars[charPosition] == " " {
                
                chars[bufferPosition] = "0"
                chars[bufferPosition.advancedBy(-1)] = "2"
                chars[bufferPosition.advancedBy(-2)] = "%"
                
                bufferPosition = bufferPosition.advancedBy(-2)
            } else {
                
                chars[bufferPosition] = chars[charPosition]
            }
            
            charPosition = charPosition.advancedBy(-1)
            bufferPosition = bufferPosition.advancedBy(-1)
        }
        
        return String(chars)
    }
}

// MARK: Question 1.4
extension String {

    /// Time Complexity:  O(n)
    /// Space Complexity: O(n)
    func isPalindromePermutation() -> Bool {
        
        let validChars = self.lowercaseString.characters.filter { $0 != " " }
        let oddLength = validChars.count % 2 == 1
        var charOccurrences = [Character:Int]()
        
        for c in validChars {
            
            charOccurrences.updateValue((charOccurrences[c] ?? 0) + 1, forKey: c)
        }
        
        var middleElementFound = false
        
        for (_, count) in charOccurrences {
            
            switch (oddLength, count % 2 == 1, middleElementFound) {
                
            case (false, true, _): return false
            case (true, true, true): return false
            case (true, true, false): middleElementFound = true; break
            default: break
            }
        }
        
        return true
    }
}

// MARK: Question 1.5
extension String {

    /// Time Complexity:  O(n)
    /// Space Complexity: O(n)
    //  TODO: Make function more verbose?
    func isOneAway(From other: String) -> Bool {
        
        return Set(self.characters).subtract(other.characters).count <= 1
    }
}

// MARK: Question 1.6
extension String {
    
    /// Time Complexity:  O(n), depends on String implementation
    /// Space Complexity: O(n), depends on String implementation
    //  TODO: Check compressed string length first?
    func compress() -> String {
        
        guard !self.isEmpty else { return self }
        
        var lastChar = self.characters[self.startIndex]
        var totalCount = 1
        var compressed = ""
        
        for c in self.characters[self.startIndex.successor()..<self.endIndex] {
            
            if c != lastChar {
                
                compressed += "\(lastChar)\(totalCount)"
                
                lastChar = c
                totalCount = 1
            } else {
                
                totalCount += 1
            }
        }
        
        compressed += "\(lastChar)\(totalCount)"
        
        return compressed.characters.count > self.characters.count ? self : compressed
    }
}

class Matrix {
    
    let rows: Int
    let cols: Int
    var matrix: [[Int]]
    
    init(matrix: [[Int]]) {
        
        self.rows = matrix.count
        self.cols = matrix.isEmpty ? 0 : matrix[0].count
        
        self.matrix = matrix
    }
    
    subscript(row: Int, col: Int) -> Int {
        
        get { return matrix[row][col] }
        set { matrix[row][col] = newValue }
    }
}

// MARK: Question 1.7
extension Matrix {

    /// Time Complexity:  O(n^2)
    /// Space Complexity: O(1)
    func rotate() -> Matrix {
        
        guard self.rows == self.cols else { return self }
        
        for r in 0..<self.rows/2 {
            
            for c in r..<self.cols-1-r {
                
                let element = self[r, c]
                
                self[r, c] = self[self.rows - 1 - c, r]
                self[self.rows - 1 - c, r] = self[self.rows - 1 - r, self.cols - 1 - c]
                self[self.rows - 1 - r, self.cols - 1 - c] = self[c, self.cols - 1 - r]
                self[c, self.cols - 1 - r] = element
            }
        }
        
        return self
    }
}

// MARK: Question 1.8
extension Matrix {

    /// Time Complexity:  O(n^3) if n == m
    /// Space Complexity: O(n * m)
    //  TODO: in place?
    func zero() -> Matrix {
        
        let zeroed = self
        
        for (rowIdx, col) in self.matrix.enumerate() {
            
            for (colIdx, val) in col.enumerate() where val == 0 {
                
                for r in 0..<self.matrix.count {
                        
                    zeroed[r, colIdx] = 0
                }
                    
                for c in 0..<col.count {
                        
                    zeroed[rowIdx, c] = 0
                }
            }
        }
        
        return zeroed
    }
}

// MARK: Question 1.9
extension String {

    /// Time Complexity:  O(n + containsString)
    /// Space Complexity: O(n)
    func isRotation(Of other: String) -> Bool {
        
        return (other + other).containsString(self)
    }
}
