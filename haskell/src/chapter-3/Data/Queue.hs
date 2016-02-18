module Data.Queue where

data Queue a = Queue [a] [a]
  deriving (Show)
instance Eq a => Eq (Queue a) where
  (==) a b = let a' = reorder a
                 b' = reorder b
             in checkEq a' b'
             where checkEq (Queue xs ys) (Queue xs' ys') = ys == ys'

mkQueue :: a -> Queue a
mkQueue a = Queue [a] []

enqueue :: a -> Queue a -> Queue a
enqueue a (Queue xs ys) = Queue (a:xs) ys

dequeue :: Queue a -> Queue a
dequeue q = case reorder q of 
  (Queue xs (y:ys)) -> Queue xs ys
  otherwise -> reorder q

peek :: Queue a -> Maybe a
peek a = case reorder a of
  (Queue _ (y:ys)) -> Just y
  otherwise        -> Nothing

isEmpty :: Queue a -> Bool
isEmpty (Queue [] []) = True
isEmpty (Queue _ _ )  = False

reorder :: Queue a -> Queue a
reorder q@(Queue xs (y:ys)) = q
reorder (Queue xs []) = Queue [] (reverse xs)
