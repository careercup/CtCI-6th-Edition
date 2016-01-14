intersection :: Eq a => [a] -> [a] -> a
intersection xs ys = head [x | x <- xs, x `elem` ys]
