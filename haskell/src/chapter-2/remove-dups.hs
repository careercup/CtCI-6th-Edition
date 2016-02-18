removeDups :: Eq a => [a] -> [a]
removeDups [] = []
removeDups (x:xs) = x : filter (/= x) (removeDups xs)
