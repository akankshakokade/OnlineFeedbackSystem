package org.ofs.model;

public class Collage extends University{
		private int clgid;
		private String name;
		public int getClgid() {
			return clgid;
		}
		public void setClgid(int clgid) {
			this.clgid = clgid;
		}
		@Override
		public String getName() {
			return name;
		}
		@Override
		public void setName(String name) {
			this.name = name;
		}
}
