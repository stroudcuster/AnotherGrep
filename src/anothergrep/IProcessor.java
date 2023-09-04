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
 * This interface specifies the signatures of the callback methods invoked in 
 * response the button presses on the GrepFrame
 * @author Stroud Custer
 */
public interface IProcessor {
    /**
     * Callback method for the Process button on the GUI display.
     * The process is run in a separate thread to assure that the GUI display
     * remains responsive.
     * 
     * @param fileNames an ArrayList&lt;String&gt; containing the names fo the files to be scanned.
     * @param patternStr a String specifying the regular expression pattern to be applied to the files.
     */
    abstract void process(ArrayList<String> fileNames, String patternStr);
    
    /**
     * Callback method for the Exit button on the GUI display.
     */

    abstract void exit();
    
}
