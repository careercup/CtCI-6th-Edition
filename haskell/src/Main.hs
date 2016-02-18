module Main where

import Test.Hspec
import Test.QuickCheck
import Ch1
import Ch2
import Ch3
--import Ch4

main :: IO ()
main = do
  putStrLn "________________________Starting test suite________________________"
  ch1
  ch2
  ch3
  --ch4
