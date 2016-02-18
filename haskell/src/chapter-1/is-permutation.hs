import Data.List (sort)

isPermutation :: String -> String -> Bool
isPermutation a b = sort a == sort b
