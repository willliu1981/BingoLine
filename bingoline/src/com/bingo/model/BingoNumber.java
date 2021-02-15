package com.bingo.model;

import java.awt.Point;

public class BingoNumber {
	private Integer number;
	private Point point;
	private Boolean check;

	public BingoNumber() {
		this.number = 0;
		this.point = new Point(0, 0);
		this.check = false;
	}

	public BingoNumber(Integer num) {
		this();
		this.number = num;
	}

	public BingoNumber(Integer num, int x, int y) {
		this(num);
		this.setPoint(x, y);
	}

	public static void swapPoint(BingoNumber b1, BingoNumber b2) {
		Point temp = b1.point;
		b1.point = b2.point;
		b2.point = temp;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (this == obj) {
			res = true;
		} else {
			if (obj instanceof BingoNumber) {
				BingoNumber other = (BingoNumber) obj;
				if (this.number == null) {
					if (other.number == null) {
						res = true;
					}
				} else {
					res = this.number.equals(other.number);
				}
			}
		}
		return res;
	}

	@Override
	public int hashCode() {
		return this.number.hashCode();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void setPoint(int x, int y) {
		this.point.x = x;
		this.point.y = y;
	}

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public void check() {
		this.check = true;
	}

	public void uncheck() {
		this.check = false;
	}

	public String toString() {
		return String.format("[%d (%d,%d) %s]", this.number, this.point.x, this.point.y, this.check);
	}
}
