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
 * Contains the results of the application of the regular expression to a list
 * of files.
 * @author Stroud Custer
 */
public class GrepResult {
    private final String patternStr;
    private ArrayList<GrepResultDetail> details;
    
    /**
     * Creates and instance of GrepResult with an empty GrepResultDetail list.
     * @param patternStr a String containing the regular expression pattern.
     */
    public GrepResult(String patternStr) {
        this.patternStr = patternStr;
        this.details = new ArrayList<>();
    }
    
    /**
     * Return the regular expression pattern.
     * @return String regular expression pattern
     */
    public String getPatterStr() {
        return this.patternStr;
    }
    
    /**
     * Return the list of GrepResultDetail instances.
     * @return ArrayListf&lt;GrepResultDetail&gt;
     * @see GrepResultDetail
     */
    public ArrayList<GrepResultDetail> getDetails() {
        return this.details;
    }
    
    /**
     * Add an instance of GrepResultDetail to the list.
     * @param detail an instance of GrepResultDetail.
     * @see GrepResultDetail
     */
    public void addDetail(GrepResultDetail detail) {
        this.details.add(detail);
    }
    
    /**
     * Add an ArrayList of GrepResultDetail instances to the list.
     * @param details an ArrayList of GrepResultDetail instances.
     * @see GrepResultDetail
     */
    public void addDetails(ArrayList<GrepResultDetail> details) {
        for (GrepResultDetail detail: details) {
            this.addDetail(detail);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Pattern: " + this.patternStr + "\n");
        for (GrepResultDetail detail: this.details) {
            result.append(detail.toString());
        }
        return result.toString();
    }
       
}
