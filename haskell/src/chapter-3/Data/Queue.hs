module Data.Queue where

data Queue a = Queue [a] [a]
  deriving (Show)
instance Eq a => Eq (Queue a) where
  (==) a b = error "implement (==)"

mkQueue :: a -> Queue a
mkQueue = error "Implement mkQueue"

enqueue :: a -> Queue a -> Queue a
enqueue = error "Implement enqueue"

dequeue :: Queue a -> Queue a
dequeue = error "Implement dequeue"

peek :: Queue a -> Maybe a
peek = error "Implement peek"

isEmpty :: Queue a -> Bool
isEmpty = error "Implement isEmpty"
