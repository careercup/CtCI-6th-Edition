module Ch3 where

import Test.QuickCheck
import Test.Hspec
import Test.Stack
import Test.Queue

ch3 :: IO ()
ch3 = hspec $ do
  describe "_______________________Chapter 3 tests_______________________" $ do
    testStack
    testQueue
      
