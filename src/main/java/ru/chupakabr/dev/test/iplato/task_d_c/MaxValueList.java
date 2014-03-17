package ru.chupakabr.dev.test.iplato.task_d_c;

import ru.chupakabr.dev.test.iplato.task_b.Queryable;

import java.io.*;
import java.util.*;

/**
 * Tasks D and C. Max Value List.
 * Non thread-safe.
 *
 * Created by myltik on 17/03/2014.
 */
public class MaxValueList implements Queryable<Integer> {

    /**
     * Input file path to process
     */
    private final File file;

    /**
     * Tell the processor whether to cache all the values.
     * Warning: if enabled could lead to high memory usage in case of very large input file.
     */
    private final boolean cached;

    /**
     * Cached values. Sorted.
     */
    private final List<Integer> cache;

    /**
     * @param filepath    Input file path
     */
    public MaxValueList(String filepath) {
        this(filepath, false);
    }

    /**
     * @param file        Input file
     */
    public MaxValueList(File file) {
        this(file, false);
    }

    /**
     * @param filepath    Input file path
     * @param cached      Flag indicating whether to cache the values in memory or not
     */
    public MaxValueList(String filepath, boolean cached) {
        if (filepath == null || filepath.isEmpty()) {
            throw new IllegalArgumentException("File path must be set");
        }

        this.cached = cached;
        this.file = new File(filepath);

        cache = new ArrayList<Integer>();
    }

    /**
     * @param file        Input file path
     * @param cached      Flag indicating whether to cache the values in memory or not
     */
    public MaxValueList(File file, boolean cached) {
        if (file == null) {
            throw new IllegalArgumentException("File must be set");
        }

        this.cached = cached;
        this.file = file;

        cache = new ArrayList<Integer>();
    }

    @Override
    public Collection<Integer> query(String query) {
        if (query == null || query.isEmpty()) {
            return Collections.emptyList();
        }

        // Read values from input file
        try {
            process(-1);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot query for values", e);
        }

        // Create a set of value to find
        Set<Integer> valuesToFind = new HashSet<Integer>();
        for (String val : query.split(",")) {
            valuesToFind.add(Integer.valueOf(val));
        }

        // Fill resulting list
        Collection<Integer> res = new ArrayList<Integer>();
        for (Integer val : cache) {
            if (valuesToFind.contains(val)) {
                res.add(val);
            }
        }
        return res;
    }

    /**
     * Note: non thread-safe.
     *
     * @param n    How many top numbers to return
     * @return Return top [n] numbers parsed from the file
     * @throws java.io.IOException
     */
    public Collection<Integer> getTopValues(int n) throws IOException {
        process(n);
        return cache.subList(0, Math.min(cache.size(), n));
    }

    /**
     * Parse input file, index integers and stored all parsed integer in [cache] property.
     * Note: non thread-safe.
     *
     * @param n    How many numbers to read, -1 to read all
     * @throws java.io.IOException
     */
    protected void process(int n) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        final int startIdx = (cached && cache.size() < n) ? cache.size() : 0;

        // Clear cache if needed
        if (!cached) {
            cache.clear();
        }

        // Read the values from [startIdx] to [n]
        int idx = startIdx;
        String line;
        while ((line = fileReader.readLine()) != null) {
            if (startIdx > idx++) {
                continue;
            }

            cache.add(Integer.parseInt(line));
        }
    }

    /**
     * @return Data reader
     * @throws FileNotFoundException
     */
    protected BufferedReader getDataReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader(file));
    }
}
