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
 * This class implements a console based grep function.
 * 
 * @author Stroud Custer 
 */
public class ConsoleGrep {
    /*
     * Entry point method - the arguments passed are expected to be a regexp
     * pattern string followed the names of one ore more files to be scanned.
     * The results of the scan are printed to the console.
    */
    public static void main(String args[]) {
        if (args.length < 3) {
            System.out.println("You must provide a regex pattern and and one or more file names");
        } else {
            String pattern = args[1];
            ArrayList<String> fileNames = new ArrayList<String>();
            for (int i=2; i < args.length; i++) {
                fileNames.add(args[i]);
            }
            Grep grep = new Grep(fileNames, pattern);
            GrepResult result = grep.grepFiles();
            System.out.println(result.toString());
        }
    }
}
