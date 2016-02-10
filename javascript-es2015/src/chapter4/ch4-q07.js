'use strict';

/**
 * To get the order of the projects we just need to create a graph of the
 * projects and their dependencies and do a topological sort. To detect if an
 * order can be determined we also need to check for cycles as topological sort
 * will only work on DAGs.
 *
 * N = |projects|
 * M = |dependencies|
 * Time: O(N+M) - this assumes that the objects and we use as hashmaps and the
 * Set data type have operations that take O(1) time.
 * Additional space: O(N)
 */
export function buildOrder(projects, dependencies) {
  let adj = {},
    finished = [],
    discovered = new Set(),
    path = new Set();

  // create adjacency matrix
  projects.forEach(project => adj[project] = []);
  dependencies.forEach(edge => adj[edge[1]].push(edge[0]));
  // run topological sort
  projects.forEach(project => topologicalSort(adj, discovered, finished, path, project));

  return finished.reverse();
}

function topologicalSort(adj, discovered, finished, path, project) {
  if (discovered.has(project)) {
    return;
  }

  discovered.add(project);
  path.add(project);
  for (let neighbour of adj[project]) {
    if (path.has(neighbour)) {
      throw new Error('dependencies are cyclic');
    }

    topologicalSort(adj, discovered, finished, path, neighbour);
  }
  path.delete(project);
  finished.push(project);
}
