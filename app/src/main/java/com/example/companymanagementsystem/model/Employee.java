package com.example.companymanagementsystem.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author swati.khobragade
 */
public class Employee implements Parcelable {
    private String empName;
    private int empAge;
    private String empDesignation;
    private int empResId;


    public Employee(String empName, int empAge, String empDesignation, int empResId) {
        super();
        this.empName = empName;
        this.empAge = empAge;
        this.empDesignation = empDesignation;
        this.empResId = empResId;
    }

    protected Employee(Parcel in) {
        empName = in.readString();
        empAge = in.readInt();
        empDesignation = in.readString();
        empResId = in.readInt();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public int getEmpResId() {
        return empResId;
    }

    public void setEmpResId(int empResId) {
        this.empResId = empResId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("empName='").append(empName).append('\'');
        sb.append(", empAge=").append(empAge);
        sb.append(", empDesignation='").append(empDesignation).append('\'');
        sb.append(", empResId=").append(empResId);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(empName);
        dest.writeInt(empAge);
        dest.writeString(empDesignation);
        dest.writeInt(empResId);
    }
}
