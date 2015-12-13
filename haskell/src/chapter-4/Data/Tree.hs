module Data.Tree where

import Test.Hspec

data Tree a = Node a [Tree a] | Leaf a
  deriving (Show, Eq)

insert :: a -> Tree a -> Tree a
insert a (Node v cs) = Node v $(Leaf a):cs
insert a (Leaf v) = Node v [Leaf a]

testTree :: IO ()
testTree = hspec $ do
  describe "Tree" $ do
    it "should insert a value" $ do
      (insert 1 (Leaf 5)) `shouldBe` (Node 5 [Leaf 1])


