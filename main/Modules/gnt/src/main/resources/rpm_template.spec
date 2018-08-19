Name:               ${Name}
Version:            ${Version}
Release:            ${Release}
Summary:            ${Summary}
Group:              ${Group}
License:            ${License}
Prefix:             ${Prefix}
URL:                ${URL}
BuildRoot:          ${BuildRoot}
BuildArchitectures: ${Architecture}
%description
${Description}
%prep
%build
%install
rm -rf $RPM_BUILD_ROOT
${install_lines}
%clean
%files
%defattr(-,root,root)
${defattr_lines}
%post
%changelog

