/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/* JavaSE Packaging and Distributing Tutorial Sample Code */

package anothergrep;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Applies a regular expression to a list of files and returns the results.
 * 
 * @author Stroud Custer
 */
public class Grep {
    private final ArrayList<String> fileNames;
    private final Pattern pattern;

    /**
     * Creates an instance of Grep.
     * 
     * @param fileNames an ArrayList&lt;String&gt; containing the names of the files to be scanned.
     * @param pattern a String containing the regular expression 
     */
    public Grep(ArrayList<String> fileNames, String pattern) {
        this.fileNames = fileNames;
        this.pattern = Pattern.compile(pattern);
    }
    
    /**
     * Apply the regular expression to a single File and return the results.
     * 
     * @param file a File instance associated with the file to be scanned.
     * @return an ArrayList&lt;GrepResultDetail&gt; containing the one entry for each match found.
     * @see GrepResultDetail
     * @throws IOException 
     */
    public ArrayList<GrepResultDetail> grepFile(File file) throws IOException {
            ArrayList<GrepResultDetail> results = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            int lineNbr = 0;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNbr += 1;
                Matcher matcher = this.pattern.matcher(line);
                while (matcher.find()) {
                    results.add(new GrepResultDetail(file.getName(), 
                            lineNbr, matcher.start(), matcher.end()));
                }

            }
        return results;
    }

    /**
     * Apply the regular expression to the list of files by invoking the grepFile method on each list entry.
     * @return an instance of GrepResult representing the results of the scan
     * @see GrepResult
     */
    public GrepResult grepFiles() {
        GrepResult result = new GrepResult(this.pattern.toString());
        for (String fileName: this.fileNames) {
            File file = new File(fileName);
            if (file.exists()) {
                try {
                    result.addDetails(this.grepFile(file));
                } catch (IOException e) {
                    result.addDetail(new GrepResultDetail(file.getName(),
                            0, e));
                }
            } else {
                result.addDetail(new GrepResultDetail(file.getName(), 
                        0, new FileNotFoundException(file.getName() + 
                                " not found.")));
            }
        }
        return result;
    }
}

