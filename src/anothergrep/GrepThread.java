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

import java.util.ArrayList;

/**
 * A Thread based wrapper for the Grep class the allows the scan to be run as
 * a separate thread.
 * @see Grep
 * @author Stroud Custer
 */
public class GrepThread extends Thread {
    private final ArrayList<String> fileNames;
    private final String patternStr;
    private GrepResult result;
    
    /**
     * Creates an instance of GrepThread.
     * @param fileNames an ArrayList&lt;String&gt; of file names to be scanned.
     * @param patternStr String regular expression to be applied to the list of files.
     */
    public GrepThread(ArrayList<String> fileNames, String patternStr) {
        this.fileNames = fileNames;
        this.patternStr = patternStr;
        this.result = null;
    }
    
    @Override
    public void run() {
        Grep grep = new Grep(this.fileNames, this.patternStr);
        this.result = grep.grepFiles();
    }
    
    /**
     * Return the GrepResult instance created by Grep instance.
     * @return a GrepResult instance containing the results of the scan.
     * @see GrepResult
     */
    public GrepResult getResult() {
        return this.result;
    }
    
}
