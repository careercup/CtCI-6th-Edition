rotateMatrix :: [[Integer]] -> [[Integer]]
rotateMatrix = reverse . transpose
  where transpose = foldr (zipWith (:)) (repeat [])
