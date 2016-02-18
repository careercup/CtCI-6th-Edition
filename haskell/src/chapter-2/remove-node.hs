removeNode :: Eq a => a -> [a] -> [a]
removeNode _ [] = []
removeNode x (y:ys) | x == y = ys
                    | otherwise = y : removeNode x ys
