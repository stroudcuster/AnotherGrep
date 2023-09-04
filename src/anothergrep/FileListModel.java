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
import javax.swing.DefaultListModel;

/**
 * Provides a ListModel implementation for the JList of file names.
 * @author Stroud Custer
 */
public class FileListModel extends DefaultListModel<String> {
    private final ArrayList<String> fileNameList;
    
    /**
     * Creates an instance of FileListModel.
     * 
     * @param fileNames an ArrayList &lt;String&gt; containing the names of the files to be scanned.
     */
    public FileListModel(ArrayList<String> fileNames) {
        this.fileNameList = fileNames;
    }
    
    /**
     * Return the file name at index i.
     * @param i int index of the element to be returned.
     * @return String file name at the specified index
     */
    @Override
    public String getElementAt(int i) {
        return this.fileNameList.get(i);
    }
    
    /**
     * Return the size for the list of file names.
     * @return int size of the list
     */
    @Override
    public int getSize() {
        return this.fileNameList.size();
    }
    
}
