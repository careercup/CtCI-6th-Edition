urlEncode :: String -> String
urlEncode [] = []
urlEncode (' ':xs) = "%20" ++ urlEncode xs
urlEncode (x:xs) = x : urlEncode xs
