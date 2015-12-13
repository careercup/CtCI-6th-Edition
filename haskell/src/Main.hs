module Main where

import Test.Hspec
import Test.QuickCheck
import qualified Data.Tree as T
import qualified Data.BinaryTree as BT
import qualified Data.BST as BST

main :: IO ()
main = do
  putStrLn "________________________Starting test suite________________________"
  T.testTree
  BST.testBST
