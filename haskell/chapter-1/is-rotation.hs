import Data.List (isInfixOf)

isRotation :: String -> String -> Bool
isRotation a b = a `isInfixOf` (b ++ b)
