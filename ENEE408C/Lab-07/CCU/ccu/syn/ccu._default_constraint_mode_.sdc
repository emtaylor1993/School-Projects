# ####################################################################

#  Created by Encounter(R) RTL Compiler v11.20-s017_1 on Wed Oct 28 19:21:46 -0400 2015

# ####################################################################

set sdc_version 1.7

set_units -capacitance 1.0fF
set_units -time 1000.0ps

# Set the current design
current_design ccu

set_clock_gating_check -setup 0.0 
set_wire_load_selection_group "predcaps" -library "saed90nm_typ"
set_dont_use [get_lib_cells saed90nm_typ/ANTENNA]
set_dont_use [get_lib_cells saed90nm_typ/BUSKP]
set_dont_use [get_lib_cells saed90nm_typ/CLOAD1]
set_dont_use [get_lib_cells saed90nm_typ/DCAP]
set_dont_use [get_lib_cells saed90nm_typ/DHFILLHLH2]
set_dont_use [get_lib_cells saed90nm_typ/DHFILLHLHLS11]
set_dont_use [get_lib_cells saed90nm_typ/DHFILLLHL2]
set_dont_use [get_lib_cells saed90nm_typ/SHFILL1]
set_dont_use [get_lib_cells saed90nm_typ/SHFILL128]
set_dont_use [get_lib_cells saed90nm_typ/SHFILL2]
set_dont_use [get_lib_cells saed90nm_typ/SHFILL3]
set_dont_use [get_lib_cells saed90nm_typ/SHFILL64]
set_dont_use [get_lib_cells saed90nm_typ/TIEH]
set_dont_use [get_lib_cells saed90nm_typ/TIEL]
