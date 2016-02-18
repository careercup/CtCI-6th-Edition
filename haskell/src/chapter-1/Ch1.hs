module Ch1 where

import Test.QuickCheck
import Test.Hspec

ch1 :: IO ()
ch1 = hspec $ do
  describe "_______________________Chapter 1 tests_______________________" $ do
    it "should have tests" $ do
      True
