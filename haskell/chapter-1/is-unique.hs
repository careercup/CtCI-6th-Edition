import Data.List (sort)

differentPairs :: String -> Bool
differentPairs s = and $ zipWith (/=) s (tail s)

isUnique :: String -> Bool
isUnique = differentPairs . sort
