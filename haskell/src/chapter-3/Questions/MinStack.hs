module Questions.MinStack where

import qualified Data.Stack as S

-- Design a stack which, in addition to push and pop, has a function min which
-- returns the minimum element. push, pop, and min should all operate in O(1)
-- time.

data MinStack a = MinStack (S.Stack a) (S.Stack a)
  deriving (Eq, Show)

push :: a -> MinStack a -> MinStack a
push = error "implement push"
--push a (MinStack s1 (S.Stack [])) = MinStack (S.push a s1) (S.mkStack a)
--push a (MinStack s1 s2@(S.Stack (x:xs))) =
--  if a <= x
--  then MinStack (S.push a s1) (S.push a s2)
--  else MinStack (S.push a s1) s2

pop :: MinStack a -> MinStack a
pop = error "implement pop"

smin :: MinStack a -> Maybe a
smin = error "implement min"

mkMinStack :: a -> MinStack a
mkMinStack a = let st = S.mkStack a
               in MinStack st st
