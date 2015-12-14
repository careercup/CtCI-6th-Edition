module Test.Queue where

import Test.QuickCheck
import Test.Hspec
import Data.Queue


emptyQueue :: Queue a
emptyQueue = Queue [] []

exQueue :: Queue Int
exQueue = Queue [1,2,3,4,5] []

enqueueQueue :: Queue Int
enqueueQueue = enqueue 3 (enqueue 2 (enqueue 1 emptyQueue))

dequeueQueue :: Queue Int
dequeueQueue = dequeue (dequeue enqueueQueue)

testQueue :: SpecWith ()
testQueue =
  describe "Queue" $ do
    it "should maintain FIFO order" $ do
      peek enqueueQueue `shouldBe` Just 1
      peek dequeueQueue `shouldBe` Just 3
    describe "Eq instance" $ do
      it "should maintain equality if regardless of enqueue/dequeue state" $ do
        (Queue [1,2,3] [] == Queue [] [3,2,1]) `shouldBe` True
    describe "mkQueue" $ do
      it "should create a single element queue" $ do
        mkQueue 1 `shouldBe` Queue [1] []
    describe "enqueue" $ do
      it "should add an element to the queue" $ do
        enqueue 1 emptyQueue `shouldBe` Queue [1] []
    describe "dequeue" $ do
      it "should remove an element from the queue" $ do
        dequeue exQueue `shouldBe` Queue [] [4,3,2,1]
    describe "peek" $ do
      it "should return the next element in the queue if it exists" $ do
        peek exQueue `shouldBe` Just 5
      it "should not crash on an empty queue" $ do
        peek emptyQueue `shouldBe` (Nothing :: Maybe Int)
    describe "isEmpty" $ do
      it "should tell if a given queue is empty" $ do
        isEmpty emptyQueue `shouldBe` True
        isEmpty exQueue `shouldBe` False


