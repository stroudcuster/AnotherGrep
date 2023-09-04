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
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.io.TempDir;

/**
 *
 * @author stroud
 */
public class GrepTest {
    
    @TempDir
    static Path tempDir;
    
    static HashMap<String, String> testData = new HashMap<>();
    static HashMap<String, String> expectedResults = new HashMap<>();
    
    public GrepTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        String tempDirName = tempDir.toString() + File.pathSeparator;
        testData.put(tempDirName + "one.txt", "Harriot\nJohn\nFred\n1234\n");
        testData.put(tempDirName + "two.txt", "John\nLouie\n456");
        testData.put(tempDirName + "three.txt", "Louie\n");
        testData.put(tempDirName + "four.txt", "12345\n");
        for(String filePath: testData.keySet()) {
            try (FileWriter writer = new FileWriter(new File(filePath))) {
                    writer.append(testData.get(filePath));
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
        expectedResults.put(tempDirName + "one.txt", " ");
        expectedResults.put(tempDirName + "two.txt", " ");
        expectedResults.put(tempDirName + "three.txt", " ");
        
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of grepFile method, of class Grep.
     */
    @Test
    public void testGrepFile() {
        System.out.println("grepFile");
        for (String filePath: testData.keySet()) {
            File file = new File(filePath);
            ArrayList<String> fileNames = new ArrayList<>();
            fileNames.add(filePath);
            for (String patternStr: expectedResults.keySet()) {
                Grep instance = new Grep(fileNames, patternStr);
                String result = instance.grepFile(file).toString();
                assertEquals(expectedResults.get(patternStr), result);
            }
            break;
        }
    }

    /**
     * Test of grepFiles method, of class Grep.
     */
    @Test
    public void testGrepFiles() {
        System.out.println("grepFiles");
        Grep instance = null;
        HashMap<String, String> expResult = null;
        HashMap<String, String> result = instance.grepFiles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
