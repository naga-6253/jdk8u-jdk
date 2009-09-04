/*
 * Copyright 2006 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/**
 * @test
 * @bug 6492692
 * @summary Some JCK test failed because of the compiler warnings changes
 */

import java.security.cert.CertificateException;
import java.util.List;
import java.util.Vector;

import sun.security.provider.certpath.X509CertPath;

public class IllegalCertiticates {

    public static void main(String[] args) throws Exception {
        List certs = new Vector();
        certs.add("The 1st certificate");
        certs.add("The 2nd certificate");
        certs.add("The 3rd certificate");
        certs.add("The 4th certificate");

        try {
            X509CertPath cp = new X509CertPath(certs);
            throw new Exception("No expected CertificateException thrown");
        } catch (CertificateException ce) {
            // get the expected exception
        } catch (Exception e) {
            throw new Exception("No expected CertificateException thrown", e);
        }

    }
}
