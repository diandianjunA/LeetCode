package EveryDayExercise.ShortestPathAllKeys;

import org.junit.Test;

import java.util.*;

public class Solution {
    public int shortestPathAllKeys(String[] grid) {
        ArrayList<Key> keys = new ArrayList<>();
        Position cur=new Position();
        Position next=new Position();
        Deque<Position> positions = new LinkedList<>();
        ArrayList<Position> positionList = new ArrayList<>();
        int res=0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                Position position = new Position(i, j, 0);
                positionList.add(position);
                if(grid[i].charAt(j)>='a'&&grid[i].charAt(j)<='f'){
                    keys.add(new Key(grid[i].charAt(j),position,false));
                } else if (grid[i].charAt(j)== '@'){
                    cur.x=i;
                    cur.y=j;
                    position.isVisited=true;
                    positions.offerLast(position);
                }
            }
        }
        while(!positions.isEmpty()){
            int size = positions.size();
            for (int i = 0; i < size; i++) {
                Position pop = positions.pollFirst();
                cur.x=pop.x;
                cur.y=pop.y;
                cur.key=pop.key;
                for (int j = 0; j < 6; j++) {
                    cur.keyList[j]=pop.keyList[j];
                }
                if(cur.key==keys.size()){
                    return res;
                }
                for (int j = 0; j < 4; j++) {
                    next.x=cur.x+dx[j];
                    next.y=cur.y+dy[j];
                    next.key=cur.key;
                    for (int k = 0; k < 6; k++) {
                        next.keyList[k]=cur.keyList[k];
                    }
                    if(walk(next, keys,grid)){
                        Position position = positionList.get(next.x * grid[0].length() + next.y);
                        if(position.key!= next.key||!position.isVisited){
                            position.key= next.key;
                            for (int k = 0; k < 6; k++) {
                                position.keyList[k]=next.keyList[k];
                            }
                            position.isVisited=true;
                            positions.offerLast(position);
                        }else {
                            for (int k = 0; k < 6; k++) {
                                if(position.keyList[k]!=next.keyList[k]){
                                    position.key= next.key;
                                    for (int e = 0; e < 6; e++) {
                                        position.keyList[e]=next.keyList[e];
                                    }
                                    position.isVisited=true;
                                    positions.offerLast(position);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
    public boolean walk(Position next,List<Key> keys,String[] grid){
        if(next.x<0||next.x>= grid.length||next.y<0||next.y>=grid[0].length()){
            return false;
        }
        switch (grid[next.x].charAt(next.y)){
            case '.':
            case '@':
                return true;
            case '#':return false;
            default:
                if (grid[next.x].charAt(next.y) >= 'a' && grid[next.x].charAt(next.y) <= 'f') {
                    for (Key key : keys) {
                        if (key.type == grid[next.x].charAt(next.y)){
                            if(!next.keyList[key.type-'a']){
                                next.keyList[key.type-'a']=true;
                                next.key++;
                            }
                            return true;
                        }
                    }
                }else{
                    for (Key key : keys) {
                        if (key.type == grid[next.x].charAt(next.y)+'a'-'A'){
                            return next.keyList[key.type-'a'];
                        }
                    }
                }
        }
        return false;
    }
    @Test
    public void test1(){
        String[] grid={"@.a.#","###.#","b.A.B"};
        System.out.println(shortestPathAllKeys(grid));
    }
    @Test
    public void test2(){
        String[] grid={"@..aA","..B#.","....b"};
        System.out.println(shortestPathAllKeys(grid));
    }
    @Test
    public void test3(){
        String[] grid={"@...a",".###A","b.BCc"};
        System.out.println(shortestPathAllKeys(grid));
    }
}
class Key{
    char type;
    Position position;
    boolean isGotten;

    public Key(char type, Position position, boolean isGotten) {
        this.type = type;
        this.position = position;
        this.isGotten = isGotten;
    }
}
class Position{
    int x;
    int y;
    int key;
    boolean[] keyList;
    boolean isVisited;

    public Position() {
        isVisited=false;
        keyList=new boolean[6];
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        isVisited=false;
        keyList=new boolean[6];
    }

    public Position(int x, int y, int key) {
        this.x = x;
        this.y = y;
        this.key = key;
        isVisited=false;
        keyList=new boolean[6];
    }
}
class Solution2 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int sx = 0, sy = 0;
        Map<Character, Integer> keyToIndex = new HashMap<Character, Integer>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i].charAt(j) == '@') {
                    sx = i;
                    sy = j;
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    if (!keyToIndex.containsKey(grid[i].charAt(j))) {
                        int idx = keyToIndex.size();
                        keyToIndex.put(grid[i].charAt(j), idx);
                    }
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<int[]>();
        int[][][] dist = new int[m][n][1 << keyToIndex.size()];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        queue.offer(new int[]{sx, sy, 0});
        dist[sx][sy][0] = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1], mask = arr[2];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx].charAt(ny) != '#') {
                    if (grid[nx].charAt(ny) == '.' || grid[nx].charAt(ny) == '@') {
                        if (dist[nx][ny][mask] == -1) {
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                    } else if (Character.isLowerCase(grid[nx].charAt(ny))) {
                        int idx = keyToIndex.get(grid[nx].charAt(ny));
                        if (dist[nx][ny][mask | (1 << idx)] == -1) {
                            dist[nx][ny][mask | (1 << idx)] = dist[x][y][mask] + 1;
                            if ((mask | (1 << idx)) == (1 << keyToIndex.size()) - 1) {
                                return dist[nx][ny][mask | (1 << idx)];
                            }
                            queue.offer(new int[]{nx, ny, mask | (1 << idx)});
                        }
                    } else {
                        int idx = keyToIndex.get(Character.toLowerCase(grid[nx].charAt(ny)));
                        if ((mask & (1 << idx)) != 0 && dist[nx][ny][mask] == -1) {
                            dist[nx][ny][mask] = dist[x][y][mask] + 1;
                            queue.offer(new int[]{nx, ny, mask});
                        }
                    }
                }
            }
        }
        return -1;
    }
}