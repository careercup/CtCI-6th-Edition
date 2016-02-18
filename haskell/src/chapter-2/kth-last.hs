kthLast :: Int -> [a] -> a
kthLast k = (!! k) . reverse
