/*******************************************************************************
 * Copyright (c) 2024 Bayerische Motoren Werke Aktiengesellschaft (BMW AG)
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.eclipse.tractusx.edc.compatibility.tests.fixtures;

import org.eclipse.edc.junit.extensions.ClasspathReader;
import org.eclipse.edc.junit.extensions.EmbeddedRuntime;

import java.net.URL;

public enum Runtimes {

    CONTROL_PLANE(":runtimes:snapshot:controlplane-snapshot"),
    IDENTITY_HUB(":runtimes:snapshot:identityhub-snapshot"),
    DATA_PLANE(":runtimes:snapshot:dataplane-snapshot");

    private final String[] modules;
    private URL[] classpathEntries;

    Runtimes(String... modules) {
        this.modules = modules;
    }

    public EmbeddedRuntime create(String name) {
        if (classpathEntries == null) {
            classpathEntries = ClasspathReader.classpathFor(modules);
        }
        return new EmbeddedRuntime(name, classpathEntries);
    }

}
