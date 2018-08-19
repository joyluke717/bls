/**
 * Copyright 2016 HuaWei Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *    
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.blem.greek.type;

public enum HostTagType {
	host_uuid ("host.uuid"), 
	host_ip ("host.ip"),
	host_rack ("host.rack"),
	host_room ("host.room"),
	host_datacenter_code ("host.datacenter_code"), 
	host_az ("host.az"),
	host_region ("host.region"),
	host_service ("host.service"),
	host_owner ("host.owner"),
	host_os ("host.os"),
	host_model ("host.model"),
	host_module ("host.module"),
	tag_id ("tag.id");
	
	private final String name;       

    private HostTagType(String s) {
        name = s;
    }
    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false 
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
    
    public static HostTagType valueOfName(String name) {
    	for (HostTagType v : values()) {
            if (v.name.equals(name)) {
                return v;
            }
        }
        throw new IllegalArgumentException(
        "No enum const " + HostTagType.class + "@description." + name);
    }
}
