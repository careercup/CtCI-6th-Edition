import Data.Char (toLower, isSpace)

palindromePermutation :: String -> Bool
palindromePermutation s = length oddLetters <= 1
  where cleanString = filter (not . isSpace) $ map toLower s
        oddLetters = odd cleanString []
        odd [] acc = acc
        odd (x:xs) acc | x `elem` acc = odd xs (filter (/= x) acc)
                       | otherwise = odd xs (x:acc)
