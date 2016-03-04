/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.biz)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.osgi.jmx.activator;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Registers {@link MBeanServer} as an OSGi service.
 */
public class MBeanServerActivator implements BundleActivator {

  private ServiceRegistration<?> serviceRegistration;

  @Override
  public void start(final BundleContext context) throws Exception {
    MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    serviceRegistration = context.registerService(MBeanServer.class.getName(), mbs, null);
  }

  @Override
  public void stop(final BundleContext context) throws Exception {
    if (serviceRegistration != null) {
      serviceRegistration.unregister();
    }
  }

}
