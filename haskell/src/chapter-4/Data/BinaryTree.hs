module Data.BinaryTree where

import Test.Hspec

data BinaryTree a = BNode (BinaryTree a) a (BinaryTree a) | BLeaf a
  deriving Show
