partition :: Ord a => a -> [a] -> [a]
partition x xs = filter (< x) xs ++ filter (>= x) xs
