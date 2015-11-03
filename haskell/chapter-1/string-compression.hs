import Data.Ord (comparing)
import Data.List (group, minimumBy)

stringCompress :: String -> String
stringCompress s = minimumBy (comparing length) [compressed, s]
  where compressed = foldr (\x acc -> head x : show (length x) ++ acc) "" (group s)
