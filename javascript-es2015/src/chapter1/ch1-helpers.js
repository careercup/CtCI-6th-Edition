
export function sortString(str) {
  // This takes additional space but JS doesn't give us a way to directly
  // manipulate the character array, treat this as O(1) space
  let chars = str.split('');
  chars.sort();
  return chars.join('');
}
