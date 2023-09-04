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
 * This class implements a GUI front end for the Grep class.
 * 
 * @author Stroud Custer
 */
public class GUIGrep implements IProcessor {
    
    private GrepFrame frame;
    
    /**
     * Constructor - creates and displays the GUI display
     */
    public GUIGrep() {
        this.frame = new GrepFrame(this);
        java.awt.EventQueue.invokeLater(new GUIRunnable(this.frame));
        
    }
   
    public void process(ArrayList<String> fileNames, String patternStr) {
        GrepThread thread = new GrepThread(fileNames, patternStr);
        thread.start();
        try {
            thread.join();
            GrepResult result = thread.getResult();
            frame.postResult(result);
            
        } catch (InterruptedException e) {
            
        }
    }
    
    public void exit() {
        System.exit(0);
    }
    
    /*
     * Creates and instance of GUIGrep, which creates and presents the GUI display.
     * No arguments are required.
    */
    public static void main(String[] args) {
        GUIGrep x = new GUIGrep();
    }
}
