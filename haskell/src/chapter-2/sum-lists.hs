carry :: [Integer] -> [Integer]
carry [] = []
carry [0] = []
carry [x] = m : carry [d]
  where (d, m) = divMod x 10
carry (x:y:xs) = m : carry (y + d : xs)
  where (d, m) = divMod x 10

sumLists :: [Integer] -> [Integer] -> [Integer]
sumLists = (carry .) . zipWith (+)
