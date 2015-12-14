module Ch2 where

import Test.QuickCheck
import Test.Hspec

ch2 :: IO ()
ch2 = hspec $ do
  describe "_______________________Chapter 2 tests_______________________" $ do
    it "should have tests" $ do
      True

