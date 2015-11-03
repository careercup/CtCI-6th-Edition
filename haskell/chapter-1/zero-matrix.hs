import Data.List (transpose)

zeroMatrix :: [[Integer]] -> [[Integer]]
zeroMatrix x = [[zero i j v | (j, v) <- zip [0..] row] | (i, row) <- zip [0..] x]
  where zeroRows = zeroIndices x
        zeroCols = zeroIndices $ transpose x
        zeroIndices y = map fst $ filter snd $ zip [0..] (map (any (== 0)) y)
        zero row col val | row `elem` zeroRows = 0
                         | col `elem` zeroCols = 0
                         | otherwise = val
