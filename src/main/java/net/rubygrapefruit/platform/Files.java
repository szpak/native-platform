/*
 * Copyright 2012 Adam Murdoch
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.rubygrapefruit.platform;

import java.io.File;
import java.util.List;

/**
 * Functions to query and modify files. There are several sub-types of this interface that allow access to
 * platform specific file features.
 */
public interface Files extends NativeIntegration {
    /**
     * Returns basic information about the given file. Returns whatever file details can be efficiently calculated
     * in a single system call, which can be more efficient that querying these details separately.
     *
     * <p>When the file references a symlink, details about the symlink is returned, not the target of the symlink.
     *
     * @param file The path of the file to get details of. Follows symlinks to the parent directory of this file.
     * @return Details of the file. Returns details with type {@link FileInfo.Type#Missing} for a file that does not
     * exist.
     * @throws NativeException On failure to query the file information.
     */
    @ThreadSafe
    FileInfo stat(File file) throws NativeException;

    /**
     * Lists the entries of the given directory.
     *
     * <p>When a directory entry is a symlink, details about the symlink is returned, not the target of the symlink.</p>
     *
     * @param dir The path of the directory to list. Follows symlinks to this directory.
     * @throws NativeException On failure.
     * @throws NoSuchFileException When the specified directory does not exist.
     * @throws NotADirectoryException When the specified file is not a directory.
     */
    @ThreadSafe
    List<? extends DirEntry> listDir(File dir) throws NativeException;
}
