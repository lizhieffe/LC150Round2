package ETL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (start.equals(end)) {
            Path path = new Path();
            path.addNode(start);
            path.addNode(end);
            result.add(path.getPath());
            return result;
        }
        dict.add(end);
        LinkedList<Path> queue = new LinkedList<Path>();
        LinkedList<Path> nextQueue = new LinkedList<Path>();

        Path tmp = new Path();
        tmp.addNode(start);
        if (dict.contains(start))
        	dict.remove(start);
        queue.addLast(tmp);
        while (queue.size() > 0) {
            boolean found = false;
            nextQueue = new LinkedList<Path>();
            while (queue.size() > 0) {
                Path path = queue.removeFirst();
                if (path.getLast().equals(end)) {
                    found = true;
                    result.add(path.getPath());
                }
                else {
                    String s = path.getLast();
                    for (int i = 0; i < s.length(); ++i) {
                        for (int j = 0; j < 26; ++j) {
                            String tmpS = null;
                            if (s.length() == 1)
                            	tmpS = "" + (char)('a' + j);
                            else if (i == 0)
                                tmpS = (char)('a' + j) + s.substring(1, s.length());
                            else if (i == s.length() - 1)
                                tmpS = s.substring(0, s.length() - 1) + (char)('a' + j);
                            else
                                tmpS = s.substring(0, i) + (char)('a' + j) + s.substring(i + 1, s.length());
                            if (dict.contains(tmpS)) {
                                Path tmpPath = new Path();
                                tmpPath.copy(path);
                                tmpPath.addNode(tmpS);
                                nextQueue.addLast(tmpPath);
                            }
                        }
                    }
                }
            }
            if (found)
                return result;
            else {
                for (Path path : nextQueue)
                    dict.remove(path.getLast());
                queue = nextQueue;
            }
        }
        return result;
    }
}

class Path {
    List<String> path = new ArrayList<String>();
    
    void addNode(String s) {
        path.add(s);
    }
    
    List<String> getPath() {
        return this.path;
    }
    
    String getLast() {
        if (path.size() == 0)
            return null;
        return path.get(path.size() - 1);
    }
    
    void copy(Path p) {
        path = new ArrayList<String>(p.getPath());
    }
}