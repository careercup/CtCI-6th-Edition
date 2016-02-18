findCycle :: Eq a => [a] -> a
findCycle list = head $ snd $ cycle list list
  where cycle (x:xs) (_:y:ys) | x == y = start list xs
                              | otherwise = cycle xs ys
        cycle _ _ = (list,[])
        start (x:xs) (y:ys) | x == y = ([], x:length x xs)
                            | otherwise = let (as,bs) = start xs ys in (x:as,bs)
        length x (y:ys) | x == y = []
                        | otherwise = y:length x ys
