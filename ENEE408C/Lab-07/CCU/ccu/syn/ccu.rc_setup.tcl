#####################################################################
#
# RTL Compiler setup file
# Created by Encounter(R) RTL Compiler v11.20-s017_1
#   on 10/28/2015 19:21:46
#
#####################################################################


# This script is intended for use with RTL Compiler version v11.20-s017_1


# Remove Existing Design
###########################################################
if {[find -design /designs/ccu] ne ""} {
  puts "** A design with the same name is already loaded. It will be removed. **"
  rm /designs/ccu
}


# Libraries
###########################################################
set_attribute library {/homes/etaylor5/enee408c_user/labs/lab08/verilog/ccu/syn//saed90nm_typ.lib {}} /

set_attribute lef_library {/homes/etaylor5/enee408c_user/labs/lab08/verilog/ccu/syn//saed90nm_tech.lef /homes/etaylor5/enee408c_user/labs/lab08/verilog/ccu/syn//saed90nm.lef} /


# Design
###########################################################
read_netlist -top ccu /homes/etaylor5/enee408c_user/labs/lab08/verilog/ccu/syn/ccu.v
source /homes/etaylor5/enee408c_user/labs/lab08/verilog/ccu/syn/ccu.g
puts "\n** Restoration Completed **\n"


# Data Integrity Check
###########################################################
# program version
if {"[string_representation [get_attribute program_version /]]" != "v11.20-s017_1"} {
   mesg_send [find -message /messages/PHYS/PHYS-91] "golden program_version: v11.20-s017_1  current program_version: [string_representation [get_attribute program_version /]]"
}
# license
if {"[string_representation [get_attribute startup_license /]]" != "RTL_Compiler_Ultra"} {
   mesg_send [find -message /messages/PHYS/PHYS-91] "golden license: RTL_Compiler_Ultra  current license: [string_representation [get_attribute startup_license /]]"
}
# slack
set _slk_ [get_attribute slack /designs/ccu]
if {[regexp {^-?[0-9.]+$} $_slk_]} {
  set _slk_ [format %.1f $_slk_]
}
if {$_slk_ != "infinity"} {
   mesg_send [find -message /messages/PHYS/PHYS-92] "golden slack: infinity,  current slack: $_slk_"
}
unset _slk_
# multi-mode slack
# tns
set _tns_ [get_attribute tns /designs/ccu]
if {[regexp {^-?[0-9.]+$} $_tns_]} {
  set _tns_ [format %.0f $_tns_]
}
if {$_tns_ != "0"} {
   mesg_send [find -message /messages/PHYS/PHYS-92] "golden tns: 0,  current tns: $_tns_"
}
unset _tns_
# cell area
set _cell_area_ [get_attribute cell_area /designs/ccu]
if {[regexp {^-?[0-9.]+$} $_cell_area_]} {
  set _cell_area_ [format %.0f $_cell_area_]
}
if {$_cell_area_ != "163"} {
   mesg_send [find -message /messages/PHYS/PHYS-92] "golden cell area: 163,  current cell area: $_cell_area_"
}
unset _cell_area_
# net area
set _net_area_ [get_attribute net_area /designs/ccu]
if {[regexp {^-?[0-9.]+$} $_net_area_]} {
  set _net_area_ [format %.0f $_net_area_]
}
if {$_net_area_ != "69"} {
   mesg_send [find -message /messages/PHYS/PHYS-92] "golden net area: 69,  current net area: $_net_area_"
}
unset _net_area_
