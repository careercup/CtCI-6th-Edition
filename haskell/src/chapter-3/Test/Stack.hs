module Test.Stack where

import Data.Stack
import Test.Hspec
import Test.QuickCheck
import Data.Maybe (fromMaybe)

exStack :: Stack Int
exStack = Stack [1,2,3,4,5]

emptyStack :: Stack Int
emptyStack = Stack []

pushedStack :: Stack Int
pushedStack = push 1 (push 2 (push 3 emptyStack))

popedStack :: (Stack Int)
popedStack = pop (pop pushedStack)

testStack :: SpecWith ()
testStack = 
  describe "Stack" $ do
    it "should maintain LIFO order" $ do
      fromMaybe 0 (peek pushedStack)  `shouldBe` 1
      fromMaybe 0 (peek popedStack) `shouldBe` 3

    describe "mkStack" $ do
      it "should create a single element Stack" $ do
        (mkStack 1) `shouldBe` (Stack [1])
    describe "push" $ do
      it "should add an element to the stack" $ do
        push 0 exStack `shouldBe` Stack [0,1,2,3,4,5]
        push 1 emptyStack `shouldBe` mkStack 1
    describe "pop" $ do
      it "should remove an element from the stack" $ do
        pop exStack `shouldBe` (Stack [2,3,4,5])
        pop emptyStack `shouldBe` emptyStack
    describe "peek" $ do
      it "should return the first element in a stack" $ do
        peek exStack `shouldBe` Just 1
        peek (Stack []) `shouldBe` (Nothing :: Maybe Int)
    describe "isEmpty" $ do
      it "should tell if a given stack is empty" $ do
        isEmpty exStack `shouldBe` False
        isEmpty (Stack []) `shouldBe` True
