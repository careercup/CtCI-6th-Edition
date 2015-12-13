module Data.BST where

import Test.Hspec

data BST a = Node a (BST a) (BST a) | Leaf
  deriving (Show, Eq)

mkNode :: a -> BST a
mkNode a = Node a Leaf Leaf

insert :: (Eq a, Ord a) => a -> BST a -> BST a
insert a Leaf = Node a Leaf Leaf
insert a n@(Node b t1 t2) = if a < b 
                          then Node b (insert a t1) t2
                          else if a == b 
                            then n
                            else Node b t1 (insert a t2)

contains :: (Ord a, Eq a) => a -> BST a -> Bool
contains = error "implement contains"

exTree :: BST Integer
exTree = Node 2 (Node 0 Leaf Leaf) (Node 4 (Node 3 Leaf Leaf)(Node 5 Leaf Leaf))

testBST :: IO ()
testBST = hspec $ do
  describe "BST" $ do
    it "should have a smart constructor" $ do
      mkNode 1 `shouldBe` Node 1 Leaf Leaf
    describe "insert" $ do
      it "should insert in order" $ do
        insert 1 exTree `shouldBe` (Node 2 (Node 0 Leaf (Node 1 Leaf Leaf)) (Node 4 (Node 3 Leaf Leaf) (Node 5 Leaf Leaf)))
      it "should be idempotent (should not add duplicates)" $ do
        insert 1 (insert 1 exTree) `shouldBe` insert 1 exTree  
    describe "contains" $ do
      it "should tell if a tree contains a given value" $ do
        contains 1 exTree `shouldBe` False
        contains 2 exTree `shouldBe` True
